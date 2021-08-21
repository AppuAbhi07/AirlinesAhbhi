package com.ngairlines.classes;

public class Flight {

	private String code;
	private String orgin;
	private String dest;
	private int ticketAvailable;

	public Flight() {

	}

	public Flight(String code, String orgin, String dest, int ticketAvailable) {
		super();
		this.code = code;
		this.orgin = orgin;
		this.dest = dest;
		this.ticketAvailable = ticketAvailable;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrgin() {
		return orgin;
	}

	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getTicketAvailable() {
		return ticketAvailable;
	}

	public void setTicketAvailable(int ticketAvailable) {
		this.ticketAvailable = ticketAvailable;
	}

	@Override
	public String toString() {
		return "Flight [code=" + code + ", orgin=" + orgin + ", dest=" + dest + ", ticketAvailable=" + ticketAvailable
				+ ", getCode()=" + getCode() + ", getOrgin()=" + getOrgin() + ", getDest()=" + getDest()
				+ ", getTicketAvailable()=" + getTicketAvailable() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((orgin == null) ? 0 : orgin.hashCode());
		result = prime * result + ticketAvailable;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (orgin == null) {
			if (other.orgin != null)
				return false;
		} else if (!orgin.equals(other.orgin))
			return false;
		if (ticketAvailable != other.ticketAvailable)
			return false;
		return true;
	}

}
